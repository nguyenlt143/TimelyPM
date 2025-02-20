// src/components/Signup.jsx
import React, { useState } from "react";
import "./Signup.css";
import MyLogo from "../assets/logo.png"; // Thay bằng đường dẫn ảnh logo của bạn

export default function Signup({ onSwitchForm }) {
    const [fullName, setFullName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [rePassword, setRePassword] = useState("");

    const handleSignup = (e) => {
        e.preventDefault();
        console.log("Full Name:", fullName);
        console.log("Email:", email);
        console.log("Password:", password);
        console.log("Re-enter password:", rePassword);
        // Xử lý đăng ký (gọi API, v.v.)
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
            </div>
        </div>
    );
}
