import React, {ChangeEvent, KeyboardEvent} from 'react';
import {createState, Layout, PluginClient, styled, usePlugin, useValue} from 'flipper-plugin';
import {Button, Card, Input, List, Typography} from "antd";
import {Events, Methods} from './types'

export function plugin(client: PluginClient<Events, Methods>) {
    const plugins = createState<Plugin[]>([], {persist: 'data'});

    client.onMessage('pluginList', (newData) => {
        plugins.set(newData.map(pid => {
            return {id: pid}
        }));
    });

    client.onMessage('appendOutput', (newData) => {
        updatePlugin(newData.id, (plugin) => {
            plugin.output = (plugin.output || "") + (newData.output || "");
            return plugin;
        });
    });

    const executePlugin = (id: string) => {
        let plugin = plugins.get().find(el => el.id == id);
        if (plugin == undefined) return;
        updatePlugin(id, (plugin) => {
            plugin.output = "";
            return plugin;
        })
        client.send("execute", {
            "command": id,
            "arguments": plugin.arguments
        });
    };

    const updatePlugin = (id: string, recipe: (plugin: Plugin) => Plugin) => {
        plugins.update((draft) => {
            let pluginIndex = draft.findIndex(plugin => plugin.id == id);
            if (pluginIndex != -1) {
                draft[pluginIndex] = recipe(draft[pluginIndex]);
            }
        });
    };

    const handleRun = function(id: string) {
        return async function (_: React.MouseEvent<HTMLElement>) {
            executePlugin(id);
        };
    }

    const executeOnEnter = function(id: string) {
        return async function (e: KeyboardEvent) {
            if (e.code == "Enter") {
                executePlugin(id);
            }
        };
    }

    const handleArgumentsUpdate = function(id: string) {
        return function (e: ChangeEvent<HTMLInputElement>) {
            updatePlugin(id, (plugin) => {
                plugin.arguments = e.target.value;
                return plugin;
            })
        };
    }

    return {plugins, handleRun, handleArgumentsUpdate, executeOnEnter};
}

export function Component() {
    const instance = usePlugin(plugin);
    const plugins = useValue(instance.plugins);

    const WideCodeText = styled(Typography.Text)`
    display: block; margin-top: 10px; margin-bottom: 10px;
    code { width: 100%; display: inline-block; margin: 0; white-space: pre; }
    `;

    let renderOutput = (item: Plugin) => {
        if (item.output != undefined) {
            return <WideCodeText code>{item.output}</WideCodeText>;
        }
    };

    return (
        <Layout.ScrollContainer>
            <List
                itemLayout="vertical"
                size="large"
                dataSource={plugins}
                renderItem={item => (
                    <List.Item key={item.id}>
                        <Card title={item.id}>
                            <Input placeholder="arguments, i.e. help" onKeyPress={instance.executeOnEnter(item.id)} onChange={instance.handleArgumentsUpdate(item.id)}/>
                            <br/>
                            { renderOutput(item) }
                            <Button type="primary" style={{marginTop: "15px"}} onClick={instance.handleRun(item.id)}>Run</Button>
                        </Card>
                    </List.Item>
                )}
            />
        </Layout.ScrollContainer>
    );
}
