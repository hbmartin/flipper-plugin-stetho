type Plugin = {
    id: string;
    arguments?: string;
    output?: string;
};

type Events = {
    pluginList: string[];
    appendOutput: Plugin;
};

type Methods = {
    execute(params: {command: string, arguments: string | undefined}): Promise<void>;
};
