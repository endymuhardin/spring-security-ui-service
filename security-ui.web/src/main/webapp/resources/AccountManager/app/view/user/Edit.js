Ext.define('AM.view.user.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.jossedit',

    title : 'Edit User',
    layout: 'fit',
    autoShow: true,

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                items: [
                  /*  {
                        xtype:'textfield',
                        readOnly:true,
                        name:'id',
                        fieldLabel:'id'
                    },*/
                    {
                        xtype: 'textfield',
                        name : 'username',
                        fieldLabel: 'Username'
                    },
                    {
                        xtype: 'textfield',
                        name : 'password',
                        fieldLabel: 'Password'
                    }
                ]
            }
        ];

        this.buttons = [
            {
                text: 'Save',
                action: 'save'
            },
            {
                text: 'Cancel',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    }
});