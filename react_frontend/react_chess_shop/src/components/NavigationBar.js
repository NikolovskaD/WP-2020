import React, {Component} from 'react';
import {Navbar, Nav, Form, FormControl, Button} from "react-bootstrap";
import {Link} from "react-router-dom";
import {faChess} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

export default  class NavigationBar extends Component{
    render() {
        return (
            <Navbar bg="dark" variant="dark">
                <Link to={""} className="navbar-brand">
                    <FontAwesomeIcon icon={faChess} /> Chess Shop
                </Link>
                <Nav className="mr-auto">
                    <Link to={"products"} className="nav-link">Products</Link>
                    <Link to={"manufacturers"} className="nav-link">Manufacturers</Link>
                    <Link to={"play"} className="nav-link">Play</Link>
                </Nav>
                <Form inline>
                    <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                    <Button variant="outline-light">Search</Button>
                </Form>
            </Navbar>
        );
    }
}

