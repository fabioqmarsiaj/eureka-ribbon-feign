#!/bin/bash

cd /usr/bin/
./mongo
use test
db.songs.find()
db.songs.drop()
db.songs.insert( { title: "musica1" } )
db.songs.insert( { title: "musica2" } )
db.songs.insert( { title: "musica3" } )
db.songs.insert( { title: "musica4" } )
db.songs.insert( { title: "musica5" } )
db.songs.insert( { title: "musica6" } )
db.songs.insert( { title: "musica7" } )
db.songs.insert( { title: "musica8" } )
db.songs.insert( { title: "musica9" } )
db.songs.insert( { title: "musica10" } )
db.songs.find()
