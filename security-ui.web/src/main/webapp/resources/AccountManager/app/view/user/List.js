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