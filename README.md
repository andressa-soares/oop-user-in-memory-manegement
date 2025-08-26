# User Management (Console App)

## Overview
A simple **Java console application** to manage users in memory.  
It allows you to register users, list all registered users, change a username, and remove a user by email.  
The app demonstrates core OOP, collections (`ArrayList`), input handling with `Scanner`, and simple data validation/formatting.

---

## Features
- **Register user**
  - Name, username, email, phone
  - Validates email with a regex
  - Validates phone as 11 digits (Brazil format)
- **List users**
  - Pretty-prints data
  - Formats phone as `(<DD>) <XXXXX>-<XXXX>`
- **Change username**
  - Finds user by current username (case-insensitive)
- **Remove user**
  - Finds and removes by email (case-insensitive)

---

## Project Structure
```
src/
└─ br/com/
   ├─ Main.java                 # Entry point & user tab menu (Scanner)
   └─ service/
      └─ UserService.java       # In-memory user operations & validation
model/
└─ User.java                    # POJO: name, username, email, phone (+ toString)
```

> Note: Package declarations should match your folders (e.g., `package br.com;`, `package service;`, `package model;`).

---

## Usage (Console Flow)

```
====================
USER TAB MENU
====================
1 - Register user
2 - View registered users
3 - Change username
4 - Remove user
5 - Return to the main menu

Enter your choice (1-5):
```

### Register user (validations)
- **Email** must match: `^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$`
- **Phone** must be **11 digits** (`\d{11}`)  
  - Printed as: `(<DD>) <XXXXX>-<XXXX>` via `String.format("(%s) %s-%s", ...)`

If invalid, the app prompts again:
- `Invalid email! Please register again.`
- `Invalid phone number! Please register again.`

---

## Core Classes

### `User`
```java
private String name;
private String username;
private String email;
private String phone;
```
- Getters/Setters for all fields
- `toString()` returns a readable summary

### `UserService`
- `registerUser(Scanner)`  
  Reads input, validates email/phone, stores `User` in `List<User>`
- `listAllUsers()`  
  Prints all users; formats phone `(DD) XXXXX-XXXX`
- `changeUsername(Scanner)`  
  Finds by current username (case-insensitive), updates it
- `removeUser(Scanner)`  
  Finds by email (case-insensitive), removes it

### `Main`
- Displays the **User Tab Menu**
- Reads options with `Scanner`
- Calls `UserService` methods
- Uses `nextLine()` after `nextInt()` to consume newline