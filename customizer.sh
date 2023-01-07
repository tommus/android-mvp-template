#!/usr/local/bin/bash

# Verify bash version. MacOS comes with bash 3 preinstalled.
if [[ ${BASH_VERSINFO[0]} -lt 4 ]]
then
  echo "You need at least bash 4 to run this script."
  exit 1
fi

# Exit when any command fails.
set -e

if [[ $# -lt 2 ]]; then
   echo "Usage: bash customizer.sh my.new.package [ApplicationName]" >&2
   exit 2
fi

PACKAGE=$1
APPNAME=$2
SUBDIR=${PACKAGE//.//} # Replaces . with /

ORG_PACKAGE="windly.template"
ORG_APPNAME="TemplateApplication"
ORG_SUBDIR=${ORG_PACKAGE//.//} # Replaces . with /

# Reorganize packages and files.
echo "Moving $n/java/$ORG_SUBDIR to $n/java/$SUBDIR..."
for n in $(find . -type d \( -path '*/src/main' \) )
do
  mkdir -p $n/java/$SUBDIR
  mv $n/java/$ORG_SUBDIR/* $n/java/$SUBDIR
  rm -rf mv $n/java/dev
done

# Rename packages and imports in kotlin files.
echo "Renaming imports and packages in kotlin files to $PACKAGE..."
find ./ -type f -name "*.kt" -exec sed -i.bak "s/package $ORG_PACKAGE/package $PACKAGE/g" {} \;
find ./ -type f -name "*.kt" -exec sed -i.bak "s/import $ORG_PACKAGE/import $PACKAGE/g" {} \;
find ./ -type f -name "Application.kt" -exec sed -i.bak "s/$ORG_PACKAGE/$PACKAGE/g" {} \;

# Rename imports in gradle files.
echo "Renaming imports in gradle files to $PACKAGE..."
find ./ -type f -name "*.gradle" -exec sed -i.bak "s/import $ORG_PACKAGE/import $PACKAGE/g" {} \;
find ./ -type f -name "*.kts" -exec sed -i.bak "s/$ORG_PACKAGE/$PACKAGE/g" {} \;

echo "Cleaning up..."
find . -name "*.bak" -type f -delete

# Rename app.
if [[ $APPNAME ]]
then
    echo "Renaming app to $APPNAME..."
    find ./ -type f \( -name "$ORG_APPNAME.kt" -or -name "settings.gradle.kts" -or -name "*.xml" -or -name "Application.kt" \) \
      -exec sed -i.bak "s/$ORG_APPNAME/$APPNAME/g" {} \;
    find ./ -name "$ORG_APPNAME.kt" | sed "p;s/$ORG_APPNAME/$APPNAME/" | tr '\n' '\0' | xargs -0 -n 2 mv
    find . -name "*.bak" -type f -delete
fi

# Remove additional files.
echo "Removing additional files..."
rm -rf CONTRIBUTING.md LICENSE README.md customizer.sh
rm -rf .git/
echo "Done!"
