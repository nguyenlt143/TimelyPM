// src/App.js
import React, { useState } from "react";
import Login from "./components/Login";
import Signup from "./components/Signup";

function App() {
  const [isLogin, setIsLogin] = useState(true);

  // Toggle qua lại giữa Login <-> Signup
  const toggleForm = () => {
    setIsLogin(!isLogin);
  };

  return (
      <div className="App">
        {isLogin ? (
            <Login onSwitchForm={toggleForm} />
        ) : (
            <Signup onSwitchForm={toggleForm} />
        )}
      </div>
  );
}

export default App;
