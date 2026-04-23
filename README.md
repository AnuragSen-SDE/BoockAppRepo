# 📚 Boock Android Take-Home — Reader Mini

A lightweight Android reading app prototype built as part of the **Boock Mobile App Developer Take-Home Assignment**.

This app allows users to browse a library, view book details, read content, and resume reading — all with local persistence.

---

## ⏱️ Timebox

- Focus: Core functionality, clean architecture, and scalability

---

## 🚀 Features Implemented

### 1️⃣ Home / Library
- Displays list of books
- Shows:
  - Title
  - Author
  - Reading status
- 🔍 Search by title or author
- ⚠️ Handles states:
  - Loading
  - Empty
  - Error

---

### 2️⃣ Book Detail Screen
- Displays:
  - Title
  - Author
  - Preview content
- CTA Button:
  - "Start Reading"
  - "Continue Reading"
- 📌 Bookmark / remove from favorites

---

### 3️⃣ Reader Screen
- Displays full content
- 📏 Adjustable text size (via slider)
- 🌙 Dark mode toggle
- 📍 Maintains reading context (basic persistence-ready structure)

---

### 4️⃣ Local Persistence
- Built using Room Database + SharedPreferences
- Persists:
  - Bookmarks
  - Reading state (started / not started)
- Survives app restarts

---

## 🏗️ Architecture

The app follows **MVVM architecture**:

- **UI Layer** → Jetpack Compose
- **ViewModel** → StateFlow-based state management
- **Repository Layer** → Data abstraction
- **Local Storage** → Room DB + SharedPreferences

---

## 🧰 Tech Stack

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Hilt (Dependency Injection)
- Room Database
- Navigation Compose
- StateFlow / Flow

---

## 📂 Project Structure

```bash id="structure"
data/
  ├── local/
  │   ├── dao/
  │   ├── entity/
  │   └── database/
  ├── repository/

di/                 # Hilt Modules

ui/
  ├── screens/
  ├── components/

navigation/

util/
  ├── DummyData
  └── SharedPreferences

MainActivity.kt
