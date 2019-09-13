#!/bin/bash

cd /usr/bin/
./mongo
use test
db.song.find()
db.song.drop()
db.song.insert( { title: "musica1" } )
db.song.insert( { title: "musica2" } )
db.song.insert( { title: "musica3" } )
db.song.insert( { title: "musica4" } )
db.song.insert( { title: "musica5" } )
db.song.insert( { title: "musica6" } )
db.song.insert( { title: "musica7" } )
db.song.insert( { title: "musica8" } )
db.song.insert( { title: "musica9" } )
db.song.insert( { title: "musica10" } )
db.song.find()
