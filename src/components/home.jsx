import React from 'react';
import './App.css';
import logo from '../../../IdeaProjects/untitled2/src/components/logo.png';

function App() {
    return (
        <div className="container">
            {/* Thanh header trên cùng */}
            <header className="header">
                <div className="left-nav">
                    {/* Logo hoặc icon thương hiệu */}
                    <div className="logo">
                        <img
                            src={logo}
                            alt="Logo"
                            style={{width: 30, height: 30}}
                        />
                    </div>
                    {/* Menu chính */}
                    <nav className="main-menu">
                        <ul>
                            <li><a href="#your-work">Your work</a></li>
                            <li className="active"><a href="#projects">Projects</a></li>
                            <li><a href="#filters">Filters</a></li>
                            <li><a href="#dashboards">Dashboards</a></li>
                            <li><a href="#teams">Teams</a></li>
                            <li><a href="#plans">Plans</a></li>
                            <li><a href="#apps">Apps</a></li>
                        </ul>
                    </nav>
                </div>
                <div className="right-nav">
                    <button className="create-btn">Create</button>
                    <div className="user-avatar">
                        <img
                            src="https://via.placeholder.com/30?text=U"
                            alt="User Avatar"
                        />
                    </div>
                </div>
            </header>

            {/* Nội dung chính */}
            <main>
                <div className="projects-header">
                    <h1>Projects</h1>
                </div>

                {/* Thanh tìm kiếm & lọc */}
                <div className="filter-bar">
                    <div className="search-filter-group">
                        <input
                            className="search-input"
                            placeholder="Search Projects"
                        />
                        <select className="product-filter">
                            <option value="">Filter by product</option>
                            <option value="product1">Product 1</option>
                            <option value="product2">Product 2</option>
                        </select>
                    </div>
                    <button className="create-project-btn">Create project</button>
                </div>

                {/* Bảng danh sách dự án */}
                <table className="projects-table">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>progress</th>
                        <th>Lead</th>
                        <th>Project_URL</th>
                        <th>More actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <span className="star-icon">★</span> A2FY
                        </td>
                        <td>LERNARIA</td>
                        <td>VU MANH DAT</td>
                        <td><span className="gear-icon">⚙</span></td>
                        <td>
                            <button className="more-btn">⋮</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span className="star-icon">★</span> TELEMY
                        </td>
                        <td>TP</td>
                        <td>LE TUNG NGUYEN</td>
                        <td><span className="gear-icon">⚙</span></td>
                        <td>
                            <button className="more-btn">⋮</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span className="star-icon">★</span> COMS
                        </td>
                        <td>TIM</td>
                        <td>LEVANDUC</td>
                        <td><span className="gear-icon">⚙</span></td>
                        <td>
                            <button className="more-btn">⋮</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </main>
        </div>
    );
}

export default App;
