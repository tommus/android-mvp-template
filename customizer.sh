#!/usr/local/bin/bash

# Verify bash version. MacOS comes with bash 3 preinstalled.
if [[ ${BASH_VERSINFO[0]} -lt 4 ]]; then
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
APP_NAME=$2
SUBDIR=${PACKAGE//.//} # Replaces . with /

ORG_PACKAGE="windly.template"
ORG_APP_NAME="TemplateApplication"
ORG_SUBDIR=${ORG_PACKAGE//.//} # Replaces . with /

# Reorganize packages and files.
echo "Moving $n/java/$ORG_SUBDIR to $n/java/$SUBDIR..."
for n in $(find . -type d \( -path '*/src/main' \)); do
  mkdir -p $n/java/$SUBDIR
  mv $n/java/$ORG_SUBDIR/* $n/java/$SUBDIR
  rm -rf mv $n/java/windly
done

# Rename packages and imports in kotlin files.
echo "Renaming imports and packages in kotlin files to $PACKAGE..."
find ./ -type f -name "*.kt" -exec sed -i.bak "s/package $ORG_PACKAGE/package $PACKAGE/g" {} \;
find ./ -type f -name "*.kt" -exec sed -i.bak "s/import $ORG_PACKAGE/import $PACKAGE/g" {} \;
find ./ -type f -name "Application.kt" -exec sed -i.bak "s/$ORG_PACKAGE/$PACKAGE/g" {} \;

# Rename packages in manifest files.
echo "Renaming packages in manifest files to $PACKAGE..."
find ./ -type f -name "AndroidManifest.xml" -exec sed -i.bak "s/$ORG_PACKAGE/$PACKAGE/g" {} \;

# Rename imports in gradle files.
echo "Renaming imports in gradle files to $PACKAGE..."
find ./ -type f -name "*.gradle" -exec sed -i.bak "s/import $ORG_PACKAGE/import $PACKAGE/g" {} \;
find ./ -type f -name "*.kts" -exec sed -i.bak "s/$ORG_PACKAGE/$PACKAGE/g" {} \;

# Rename styles.
echo "Renaming base styles to $APP_NAME..."
find ./ -type f -name "styles.xml" -exec sed -i.bak "s/Template/$APP_NAME/g" {} \;

# Rename themes.
echo "Renaming base themes to $APP_NAME..."
find ./ -type f -name "themes.xml" -exec sed -i.bak "s/Theme.Template/Theme.$APP_NAME/g" {} \;
find ./ -type f -name "AndroidManifest.xml" -exec sed -i.bak "s/Theme.Template/Theme.$APP_NAME/g" {} \;

echo "Cleaning up..."
find . -name "*.bak" -type f -delete

# Rename app.
if [[ $APP_NAME ]]; then
  echo "Renaming app to $APP_NAME..."
  find ./ -type f -name "$ORG_APP_NAME.kt" -exec sed -i.bak "s/$ORG_APP_NAME/${APP_NAME}Application/g" {} \;
  find ./ -type f -name "*.xml" -exec sed -i.bak "s/$ORG_APP_NAME/${APP_NAME}Application/g" {} \;
  find ./ -type f -name "Application.kt" -exec sed -i.bak "s/$ORG_APP_NAME/$APP_NAME/g" {} \;
  find ./ -name "$ORG_APP_NAME.kt" | sed "p;s/$ORG_APP_NAME/${APP_NAME}Application/" | tr '\n' '\0' | xargs -0 -n 2 mv
  find . -name "*.bak" -type f -delete
fi

# Remove additional files.
echo "Removing additional files..."
rm -rf CONTRIBUTING.md LICENSE README.md customizer.sh
rm -rf .git/
echo "Done!"
