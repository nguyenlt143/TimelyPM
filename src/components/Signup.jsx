// src/components/Signup.jsx
import React, { useState } from "react";
import "./Signup.css";
import MyLogo from "../assets/logo.png"; // Thay bằng đường dẫn ảnh logo của bạn

export default function Signup({ onSwitchForm }) {
    const [fullName, setFullName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [rePassword, setRePassword] = useState("");

    // Hàm xử lý signup
    const handleSignup = (e) => {
        e.preventDefault();
        console.log("Full Name:", fullName);
        console.log("Email:", email);
        console.log("Password:", password);
        console.log("Re-enter password:", rePassword);
        // Gọi API đăng ký...
    };

    // Hàm xử lý nút "Login with Google"
    const handleGoogleLogin = () => {
        console.log("Google Signup");
        // Gọi API Google OAuth, v.v.
    };

    return (
        <div className="signup-container">
            {/* Nút login (chuyển về form Login) */}
            <div className="login-button">
                <span onClick={onSwitchForm}>login</span>
            </div>

            <div className="signup-form">
                <div className="logo">
                    <img src={MyLogo} alt="logo" />
                </div>
                <h2>Create an Account</h2>

                <form onSubmit={handleSignup}>
                    <div className="form-group">
                        <label htmlFor="fullName">Full name</label>
                        <input
                            id="fullName"
                            type="text"
                            placeholder="Full name"
                            value={fullName}
                            onChange={(e) => setFullName(e.target.value)}
                            required
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="email">Enter your mail</label>
                        <input
                            id="email"
                            type="email"
                            placeholder="You@yourmail.com"
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
                            placeholder="Password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="rePassword">Re-enter password</label>
                        <input
                            id="rePassword"
                            type="password"
                            placeholder="Re-enter password"
                            value={rePassword}
                            onChange={(e) => setRePassword(e.target.value)}
                            required
                        />
                    </div>

                    <button type="submit" className="signup-btn">
                        Sign up
                    </button>
                </form>

                {/* Nút Google giống bên Login */}
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
