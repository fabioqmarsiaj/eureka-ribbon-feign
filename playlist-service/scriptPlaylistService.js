#!/bin/bash

cd /usr/bin/
./mongo
use test
db.playlists.find()
db.playlists.drop()
db.playlists.insert( { name: "playlist1" , songIds: [] } )
db.playlists.insert( { name: "playlist2" , songIds: [] } )
db.playlists.insert( { name: "playlist3" , songIds: [] } )
db.playlists.insert( { name: "playlist4" , songIds: [] } )
db.playlists.insert( { name: "playlist5" , songIds: [] } )
db.playlists.insert( { name: "playlist6" , songIds: [] } )
db.playlists.insert( { name: "playlist7" , songIds: [] } )
db.playlists.insert( { name: "playlist8" , songIds: [] } )
db.playlists.insert( { name: "playlist9" , songIds: [] } )
db.playlists.insert( { name: "playlist10" , songIds: [] } )
db.playlists.find()
