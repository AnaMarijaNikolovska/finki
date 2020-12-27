import React from "react";
import Nav from "react-bootstrap/Nav";
import NavDropdown from "react-bootstrap/NavDropdown";
import Button from "react-bootstrap/Button";
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl';
import Navbar from "react-bootstrap/Navbar";
import {Link} from "@reach/router";

export default function Header(){
    return(
        <div>
            <Navbar bg="dark" variant="dark">
                <Link className={"nav-link"} to={"/"}>Home </Link>
                <Nav className="mr-auto">
                    <NavDropdown title="Course" id="basic-nav-dropdown">
                        <Link className={"dropdown-item"} to={"/courses"}>View Courses </Link>
                        <Link className={"dropdown-item"} to={"/courses/add"}>Add Course</Link>
                    </NavDropdown>
                    <NavDropdown title="Student" id="basic-nav-dropdown">
                        <Link className={"dropdown-item"} to={"/students"}>View Students </Link>
                        <Link className={"dropdown-item"} to={"/students/add"}>Add Students </Link>
                    </NavDropdown>
                    <NavDropdown title="Teacher" id="basic-nav-dropdown">
                        <Link className={"dropdown-item"} to={"/teachers"}>View Teachers </Link>
                        <Link className={"dropdown-item"} to={"/teachers/add"}>Add Teacher </Link>
                    </NavDropdown>
                </Nav>
            </Navbar>
        </div>
    )
}