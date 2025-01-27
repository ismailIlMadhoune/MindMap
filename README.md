# Mind Map Application 

The **Mind Map** is a powerful, no-frills tool designed to help competitive programmers, developers, and problem-solvers organize their thoughts, sketch code ideas, and visualize complex problems, without being distracted by looking at different monitors or papers. Whether you're prepping for a coding interview, brainstorming algorithmic solutions, or mapping out the flow of a project or working on code with others, this tool has everything you need to efficiently structure and share your ideas.

With **Mind Map**, you can:

- **Sketch your code** and **algorithmic approaches** directly within the mind map, allowing you to outline your thought process visually before diving into the implementation.
- **Run and test your code** within the app while you build your mind map—perfect for trying out quick snippets or running algorithms as you plan.
- **Organize your problems** hierarchically, helping you break down complex problems into smaller, manageable components.
- **Map out your solutions** step-by-step, connecting concepts and code blocks to ensure clarity and prevent logic gaps.
- **Collaborate** (Coming Soon!) in real-time, so you can easily share your thoughts and problem-solving approach with teammates or peers.

Ideal for competitive programmers and anyone who thrives on efficiency, clarity, and fast iteration in problem-solving.

---


## Key Features of the Platform:

- **Interactive Idea Creation**: Easily add and modify items to represent your ideas, tasks, or code snippets. Use simple sketching tools built with **HTML5 Canvas** to visualize concepts quickly and clearly.

- **Drag-and-Drop Interface**: Effortlessly rearrange sections of the page to organize your thoughts and tasks. Create a flexible workspace that adapts to your needs.

- **Fully Customizable Design**: Personalize each element with different colors, shapes, and icons for a visually organized, easy-to-understand layout.

- **Integrated Code Execution**: Write and run your code directly within the platform using the **Monaco Editor**, a powerful code editor integrated into the website. After writing your code, you can execute it through the **JDoodle API** to test and refine your work in real-time while mapping out your ideas.

- **Real-Time Collaboration (Coming Soon!)**: Work together with your team on shared projects in real-time, enhancing collaboration and idea-sharing.
- **User Management (Coming Soon!)**: A database will be implemented for handling user accounts, allowing for a more personalized experience, including user authentication and project management.

---

## 💻 How to Deploy Locally

Follow these steps to set up and test the application locally. **Note:** Ensure the backend server is running first before starting the frontend. The frontend relies on the backend API to function properly.

### **Prerequisites**

- **Node.js** and **npm** installed on your system.
- **Java** (JDK 17 or later) and **Maven** installed on your system for the Spring Boot backend.

### **Steps to Run Locally**

1. **Clone the Repository**  
   Clone the project repository to your local machine:
   ```bash
   git clone https://github.com/ismailIlMadhoune/MindMap
   cd <repository-folder>
   ```

2. **Run the Backend Server (Spring Boot)**  
   Navigate to the backend directory where your Spring Boot application is located:
   ```bash
   cd server/mindmap-backend-main
   ```

   Ensure the `application.properties` or `application.yml` file is correctly set up (e.g. server port, etc.).

   **Run the Spring Boot Application** as a Java program (via your IDE or command line):
   ```bash
   mvn spring-boot:run
   ```

   Alternatively, if you have an IDE like IntelliJ or Eclipse, you can run the Spring Boot app directly from there by running the `MindMapApplication` class (or your main class).

   You should see output similar to this when the server starts successfully:
   ```bash
   2025-01-26 14:00:00.000  INFO 12345 --- [           main] c.e.m.MindMapApplication   : Started MindMapApplication in 5.678 seconds (JVM running for 6.789)
   ```

   The backend should now be running on the default port, typically `http://localhost:5002` (or another port as configured).

3. **Install Frontend Dependencies**  
   Navigate to the frontend directory and install the required dependencies:
   ```bash
   cd client/mindmap-frontend-main
   npm install
   ```

4. **Start the Frontend Development Server**  
   Run the following command to start the frontend server:
   ```bash
   npm run dev
   ```

   This will start the React development server. The output will typically indicate something like:
   ```bash
   > frontend@0.1.0 dev
   > vite

   VITE v2.0.0  ready in 300ms

   ➜  Local:   http://localhost:5173/
   ➜  Network: use `--host` to expose
   ```

   You can now access the app in your browser at `http://localhost:5173`.

5. **Access the Application**  
   Open your browser and visit the following URLs:
   - Frontend: [http://localhost:5173](http://localhost:5173)
   - Backend: [http://localhost:5002](http://localhost:5002)

---

## 🌐 Remote Deployment Status

I am actively working on deploying the Mind Map application remotely so you can access it online without local setup. Stay tuned for updates on the hosted version!

---

## 🛠️ Technologies Used

- **Frontend**: React.js, custom CSS
- **Backend**: Spring Boot, Java, Maven
- **Deployment** (Coming Soon): Hosting on Render and Netlify.
---

## 📂 Project Structure

```
MindMap/
├── client/mindmap-frontend-main/
│   ├── src/
│   ├── public/
│   ├── package.json
│   └── ...
├── server/mindmap-backend-main/
│   ├── src/
│   ├── config/
│   ├── application.properties (or application.yml)
│   ├── pom.xml
│   └── ...
└── README.md
```

---

##  Feedback and Contributions

If you have suggestions, feedback, or feature requests, feel free to reach out or create an issue in the repository. 

---

###  Author

**Ismail Il Madhoune**  

---

### Summary of Commands

1. **Clone the repo:**
   ```bash
   git clone https://github.com/ismailIlMadhoune/MindMap
   cd <repository-folder>
   ```

2. **Run the backend (Spring Boot):**
   ```bash
   cd server/mindmap-backend-main
   mvn spring-boot:run
   ```

3. **Install frontend dependencies:**
   ```bash
   cd client/mindmap-frontend-main
   npm install
   ```

4. **Start frontend development server:**
   ```bash
   npm run dev
   ```

---
