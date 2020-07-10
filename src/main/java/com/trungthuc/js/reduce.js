
//sử dụng reduce tìm phần tử khác nhau giữa hai array
function Difference(arr = [], oarr = []) {
    return arr.reduce((t, v) => (!oarr.includes(v) && t.push(v), t), []);
}

const arr1 = [1, 2, 3, 4, 5];
const arr2 = [2, 3, 6]
Difference(arr1, arr2); // [1, 4, 5]

//----------------------

//Làm phẳng một array sử dụng reduce
function Flat(arr = []) {
    return arr.reduce((t, v) => t.concat(Array.isArray(v) ? Flat(v) : v), [])
}
const arr = [0, 1, [2, 3], [4, 5, [6, 7]], [8, [9, 10, [11, 12]]]];
Flat(arr); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]

//----------------------

//Array trùng lặp phần tử sử dụng reduce

function Uniq(arr = []) {
    return arr.reduce((t, v) => t.includes(v) ? t : [...t, v], []);
}
const arr = [2, 1, 0, 3, 2, 1, 2];
Uniq(arr); // [2, 1, 0, 3]
//-----------


//Reduce thay thế max() và min()
function Max(arr = []) {
    return arr.reduce((t, v) => t > v ? t : v);
}

function Min(arr = []) {
    return arr.reduce((t, v) => t < v ? t : v);
}
const arr = [12, 45, 21, 65, 38, 76, 108, 43];
Max(arr); // 108
Min(arr); // 12
//----------------

//Đếm số lượng giống nhau trong một array sử dụng recude

function Count(arr = []) {
    return arr.reduce((t, v) => (t[v] = (t[v] || 0) + 1, t), {});
}
const arr = [0, 1, 1, 2, 2, 2];
Count(arr); // { 0: 1, 1: 2, 2: 3 }

//---------------


//group by use reduce
function Group(arr = [], key) {
    return key ? arr.reduce((t, v) => (!t[v[key]] && (t[v[key]] = []), t[v[key]].push(v), t), {}) : {};
}
const arr = [
    { area: "GZ", name: "YZW", age: 27 },
    { area: "GZ", name: "TYJ", age: 25 },
    { area: "SZ", name: "AAA", age: 23 },
    { area: "FS", name: "BBB", age: 21 },
    { area: "SZ", name: "CCC", age: 19 }
];
Group(arr, "area"); // { GZ: Array(2), SZ: Array(2), FS: Array(1) }

//------------------

//Phân tích một Object sang params url

function StringifyUrlSearch(search = {}) {
    return Object.entries(search).reduce(
        (t, v) => `${t}${v[0]}=${encodeURIComponent(v[1])}&`,
        Object.keys(search).length ? "?" : ""
    ).replace(/&$/, "");
}

StringifyUrlSearch({ age: 55, name: "anonystick" }); // "?age=55&name=anonystick"

//Get value của key của một Object cho trước
function GetKeys(obj = {}, keys = []) {
    return Object.keys(obj).reduce((t, v) => (keys.includes(v) && (t[v] = obj[v]), t), {});
}
const target = { a: 1, b: 2, c: 3, d: 4 };
const keyword = ["a", "d"];
GetKeys(target, keyword); // { a: 1, d: 4 }

//Chuyển đổi một array object sang object sử dụng redcuce
const people = [
    { area: "GZ", name: "YZW", age: 27 },
    { area: "SZ", name: "TYJ", age: 25 }
];
const map = people.reduce((t, v) => {
    const { name, ...rest } = v;
    t[name] = rest;
    return t;
}, {}); // { YZW: {…}, TYJ: {…} }

// parseUrl hoàn chỉnh sẽ là.

    function parseUrl(str) {
        return str.split('&').reduce((obj, pair) => {
            const [key, value] = pair.split('=');
            if (!value) {
                return obj;
            }
            deepObj(obj, key.split(/[\[\]]/g).filter(v => v), value);
            return obj;
        }, {});
    }

function deepObj(obj, keys, value) {

    let i = 0;
    for (; i < keys.length - 1; i++) {
        let key = keys[i];
        if (!obj[key]) {
            //obj[key] = {}; comment chỗ này
            if (keys[i + 1].match(/^\d+$/)) {
                obj[key] = [];
            } else {
                obj[key] = {};
            }
        }
        obj = obj[key];
    }
    obj[keys[i]] = value;
}