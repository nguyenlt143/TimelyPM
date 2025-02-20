// src/components/Login.jsx
import React, { useState } from "react";
import "./Login.css";
import MyLogo from "../assets/logo.png"; // Thay bằng đường dẫn ảnh logo của bạn

export default function Login({ onSwitchForm }) {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = (e) => {
        e.preventDefault();
        console.log("Email:", email, "Password:", password);
    };

    const handleGoogleLogin = () => {
        console.log("Google Login");
    };

    return (
        <div className="login-container">
            {/* Nút signup (chuyển qua form Signup) */}
            <div className="signup-button">
                <span onClick={onSwitchForm}>signup</span>
            </div>

            <div className="login-form">
                <div className="logo">
                    <img src={MyLogo} alt="logo" />
                </div>
                <h2>Welcome</h2>

                <form onSubmit={handleLogin}>
                    <div className="form-group">
                        <label htmlFor="email">Email</label>
                        <input
                            id="email"
                            type="email"
                            placeholder="you@yourmail.com"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input
                            id="password"
                            type="password"
                            placeholder="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>

                    {/* forgot password + login trên cùng 1 hàng */}
                    <div className="forgot-and-login">
                        <a href="#forgot-password" className="forgot-password-link">
                            forgot password
                        </a>
                        <button type="submit" className="login-btn">
                            login &nbsp; &gt;
                        </button>
                    </div>
                </form>

                {/* Login với Google */}
                <div className="google-login" onClick={handleGoogleLogin}>
                    <img
                        src="https://cdn-icons-png.flaticon.com/512/2991/2991148.png"
                        alt="google-icon"
                    />
                    <span>Login with Google</span>
                </div>
            </div>
        </div>
    );
}
