import React, {useState} from 'react'
import axios from '../components/AxiosConfig'
import Button from "react-bootstrap/Button";
import Form from 'react-bootstrap/Form'
import {navigate} from "@reach/router";

export function AddStudent() {

    const [student, setStudent] = useState({
        username:'',
        password:'',
        name:'',
        surname:'',
    });

    const handleChange = name => event => {
        setStudent({...student, [name]: event.target.value});
    };

    const handleSubmit = event => {
        event.preventDefault();

        axios.post("/students", student)
            .then(res => {
                navigate("/courses")
            })
    }

    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <Form.Group>
                    <Form.Label>Username</Form.Label>
                    <Form.Control placeholder="Enter username"
                                  onChange={handleChange("username")}/>
                </Form.Group>

                <Form.Group>
                    <Form.Label>Name</Form.Label>
                    <Form.Control placeholder="Enter name"
                                  onChange={handleChange("name")}/>
                </Form.Group>

                <Form.Group>
                    <Form.Label>Surname</Form.Label>
                    <Form.Control placeholder="Enter surname"
                                  onChange={handleChange("surname")}/>
                </Form.Group>

                <Form.Group>
                    <Form.Label>Password</Form.Label>
                    <Form.Control type={"password"} placeholder="Enter password"
                                  onChange={handleChange("password")}/>
                </Form.Group>

                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </div>
    )
}