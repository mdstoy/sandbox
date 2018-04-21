var data = [
    {id: 1, openerTabId: null},
    {id: 2, openerTabId: 1},
    {id: 3, openerTabId: 2},
    {id: 4, openerTabId: null},
    {id: 5, openerTabId: null},
    {id: 6, openerTabId: 5},
    {id: 7, openerTabId: 5}
];

var all = function(callback) {
    data.forEach(callback);
}

var print = function(obj) {
    console.log(obj.id);
}

all(print);
