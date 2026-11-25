#!/usr/bin/env sh
set -eu
VERSION=8.10.2
BASE="${GRADLE_USER_HOME:-$HOME/.gradle}/wrapper/dists/gradle-$VERSION-bin/manual"
GRADLE="$BASE/gradle-$VERSION/bin/gradle"
if [ ! -x "$GRADLE" ]; then
  mkdir -p "$BASE"
  ARCHIVE="$BASE/gradle.zip"
  if command -v curl >/dev/null 2>&1; then curl -fL "https://services.gradle.org/distributions/gradle-$VERSION-bin.zip" -o "$ARCHIVE"
  elif command -v wget >/dev/null 2>&1; then wget "https://services.gradle.org/distributions/gradle-$VERSION-bin.zip" -O "$ARCHIVE"
  else echo "Install curl or wget to bootstrap Gradle." >&2; exit 1; fi
  unzip -q -o "$ARCHIVE" -d "$BASE"
  rm -f "$ARCHIVE"
fi
exec "$GRADLE" "$@"
