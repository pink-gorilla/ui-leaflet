#!/bin/sh

# npm-install has to run, because shadow-cljs "release" does not update package.json
# in comparison shadow-cljs "watch" does update package.json
clojure -X:webly:npm-install

