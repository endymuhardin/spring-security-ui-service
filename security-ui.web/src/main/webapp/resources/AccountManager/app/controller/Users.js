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
Ext.define('AM.controller.Users', {
    extend: 'Ext.app.Controller',

    stores:['Users'],
    models:['User'],

    init: function() {
        this.control({
            'josslist': {
                itemdblclick: this.editUser
            },
            'jossedit button[action=save]': {
                click: this.updateUser
            }

        });
    },

    updateUser: function(button) {
        var win = button.up('window'),
                form = win.down('form'),
                record = form.getRecord(),
                values = form.getValues();

        record.set(values);
        win.close();
        this.getUsersStore().sync();
    },

    editUser: function(grid, record, item, index, e) {
        var view = Ext.create('AM.view.user.Edit');
        view.down('form').loadRecord(record);
    }
});