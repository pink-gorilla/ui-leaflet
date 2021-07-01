(ns pinkgorilla.leaflet.goldly
  (:require
   ; parent project setups
   [pinkie.default-setup] ; side-effects
   [pinkie.pinkie :refer-macros [register-component]]
   [pinkgorilla.leaflet.leaflet :refer [leaflet-map]]))

(register-component :p/leaflet leaflet-map)