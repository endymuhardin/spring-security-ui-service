Ext.define('AM.model.User', {
    extend: 'Ext.data.Model',
    fields: ['id','password','enabled', 'username', 'salt','group']
});