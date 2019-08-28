const admin = require('firebase-admin');
const functions = require('firebase-functions');

admin.initializeApp(functions.config().firebase);

var db = admin.firestore();

exports.getRooms = functions.https.onRequest(async (req, res) => {
    var arr = new Array();
    db.collection("rooms").get()
    .then((snapshot) => {
        snapshot.forEach((doc) => {
            var json = {"id":doc.id, "data": doc.data()};
            arr.push(json);
        })
        res.send(arr);
    })
    .catch((err) => {
        console.log('Error getting documents', err);
    });
});

exports.createRoom = functions.https.onRequest(async (req, res) => {
    var id = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for( var i=0; i < 20; i++ )
        id += possible.charAt(Math.floor(Math.random() * possible.length));

    var docRef = db.collection('rooms').doc(id);

    await docRef.create({ name: req.query.name }).then(() => res.send(id));
});

exports.deleteRoom = functions.https.onRequest(async (req, res) => {
    const id = req.query.id;
    let docRef = db.collection('rooms').doc(id);
    await docRef.delete().then(() => {
        res.send(`Document id: ${id} successfully deleted`);
    });
});
