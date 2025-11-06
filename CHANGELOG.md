# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.11.05

### Added

- Made a MusicDatabaseQuickTester class

- Implemented printSong(), printSongs()

### Changed

- Switched to using a record class for Song

- Changed names of displaySong() and displaySongs() to printSong() and printSongs()

- Changed contracts of readFromFile() and writeToFile() to reflect better .csv file formatting

## 2025.11.04

### Added

- Made a MusicDatabaseSecondary class

### Removed

- MusicDatabase no longer extends Comparable

## 2025.10.26

### Added

- Added sort(), readFromFile(), writeToFile(), displaySong(), displaySongs(), split(), merge() methods to MusicDatabase.java

- Created MusicDatabase.java

- Added size(), contains(), getEntryInOrder(), an internal interface for Song to MusicDatabaseKernel.java

### Changed

- The internal class Song no longer has setter methods

- The addEntry methods that could take Strings for the fields of Song, create a Song, then put it into the database were removed in favor of only having the addEntry method that takes a Song.

## 2025.10.24

### Changed

- Switched to using the SearchField enum in getEntries() and removeEntries()

### Added

- Added addEntry(), getEntries(), removeEntries(), removeEntry() methods to MusicDatabaseKernel.java

- Created MusicDatabaseKernel.java

## 2025.10.09

### Added

- MusicDatabase1.java, which includes internal class Song, a comparator for comparing the title of songs alphabetically, a constructor for musicDatabase1, versions of addEntry, and getEntry. It also includes a main method used to demonstrate the methods.

## 2025.09.21

### Added

- Designed a Calculator component

## 2025.09.19

### Added

- Designed a MusicPlaylist component
- Designed a MusicDatabase component