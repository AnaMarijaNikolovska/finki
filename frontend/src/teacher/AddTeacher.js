import React, {useState} from "react";
import axios from "../components/AxiosConfig";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import {navigate} from "@reach/router";

export default function AddTeacher() {

    const [teacher, setTeacher] = useState({
        name: '',
        surname: '',
    });

    const handleChange = name => event => {
        setTeacher({...teacher, [name]: event.target.value});
    };

    const handleSubmit = event => {
        event.preventDefault();

        axios.post("/teachers", teacher)
            .then(res => {
                navigate("/teachers")
            })
    }

    return (
        <div>
            <Form onSubmit={handleSubmit}>
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

                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </div>
    )
}