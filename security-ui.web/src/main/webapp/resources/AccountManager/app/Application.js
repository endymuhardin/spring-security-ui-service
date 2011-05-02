Ext.Loader.setConfig({enabled: true});

Ext.require([
    'Ext.app.*',
    'Ext.container.*'
]);
Ext.create('Ext.app.Application', {
    name: 'AM',

    controllers: [
        'Users'
    ],

    views: [
        'user.List'
    ],

    launch: function() {
        Ext.create('AM.view.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'josslist'
            }
        });
    }
});