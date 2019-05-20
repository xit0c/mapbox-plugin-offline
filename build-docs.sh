#!/bin/bash

echo "Executing 'dokka'"
./gradlew dokka

echo "Cleaning up './docs'"
rm -rf ./docs/*

echo "Copying javadoc to './docs'"
cp -r ./mapboxpluginoffline/build/javadoc/mapboxpluginoffline/* ./docs/

echo "Done"
