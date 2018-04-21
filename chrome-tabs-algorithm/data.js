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

// ^^^ tabs

var a = new Map();
var b = new Map();

var map = function(obj) {
    a.set(obj.id, obj);
    m = b.get(obj.openerTabId);
    if (!m) {
        m = new Array();
        b.set(obj.openerTabId, m);
    }
    m.push(obj.id);
}

all(map);

var getParent = function(id) {
    var obj = a.get(id);
    var parent = obj.openerTabId;
    if (parent) {
        return getParent(parent);
    }
    return id;
}

console.log(getParent(1));
console.log(getParent(2));
console.log(getParent(3));
console.log(getParent(4));
console.log(getParent(5));
console.log(getParent(6));
console.log(getParent(7));

var getChildren = function(id) {
    return b.get(id);
}

console.log(getChildren(1));
console.log(getChildren(2));
console.log(getChildren(3));
console.log(getChildren(4));
console.log(getChildren(5));
console.log(getChildren(6));
console.log(getChildren(7));



