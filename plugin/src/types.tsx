/**
 * Copyright (c) 2021 Harold Martin.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

export type DumperPlugin = {
    id: string;
    arguments?: string;
    output?: string;
};

export type Events = {
    pluginList: string[];
    appendOutput: DumperPlugin;
};

export type Methods = {
    execute(params: {command: string, arguments: string | undefined}): Promise<void>;
};
