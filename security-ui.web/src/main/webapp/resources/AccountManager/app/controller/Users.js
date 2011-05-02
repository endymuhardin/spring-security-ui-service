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