/*
 * Copyright (C) 2011 Deny Prasetyo <jasoet87@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
Ext.define('AM.view.user.List', {
    extend: 'Ext.grid.Panel',
    alias : 'widget.josslist',

    title : 'All Users',

    store : 'Users',
    selType: 'cellmodel',
    initComponent: function() {

        this.columns = [
            {header: 'Username',  dataIndex: 'username',  flex: 1},
            {header: 'Password', dataIndex: 'password', flex: 1},
            {header: 'Salt', dataIndex: 'salt', flex: 1},
            {
                header: 'Enabled',
                dataIndex: 'enabled',
                flex: 1,
                renderer:function(value) {
                    return (value) ? "Yes" : "No";
                }
            },
            {
                header: 'Group',
                dataIndex: 'group',
                flex: 1,
                renderer:function(value) {
                    return value.name;
                }
            }
        ];

        this.callParent(arguments);
    }

});