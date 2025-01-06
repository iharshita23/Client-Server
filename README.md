# Client-Server

A simple and robust console-based chat application built using Java, showcasing client-server architecture and socket programming. This project demonstrates real-time communication between clients through a centralized server, highlighting the capabilities of Java for networking and multithreading.

## Features
- **Client-Server Model**: Facilitates multiple clients connecting to a central server.
- **Real-Time Messaging**: Enables seamless exchange of messages between connected clients.
- **Threaded Architecture**: Uses multithreading for handling multiple client connections concurrently.
- **Scalability**: Designed to support multiple users in a single chat session.
- **Platform Independence**: Works on any platform that supports Java.

## How It Works

### Server Setup:
- The server initializes a socket and starts listening for incoming client connections.
- It manages communication with multiple clients simultaneously using threads.

### Client Connection:
- Clients connect to the server by providing the server's IP address and port.
- Once connected, clients can send and receive messages in real time.

## Technologies Used
- **Language**: Java
- **Networking**: Sockets (`ServerSocket`, `Socket`)
- **Concurrency**: Multithreading

## Use Cases
- **Learning Resource**: Ideal for understanding the basics of socket programming and client-server communication.
- **Internal Messaging**: Can be used as a lightweight messaging solution within a local network.

