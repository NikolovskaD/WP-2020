import React, {Component} from 'react';
import {Navbar, Nav, Form, FormControl, Button} from "react-bootstrap";
import {Link} from "react-router-dom";

export default  class NavigationBar extends Component{
    render() {
        return (
            <Navbar bg="dark" variant="dark">
                <Link to={""} className="navbar-brand">
                    {/*make the picture smaller!*/}
                    <img src="./././public/kingLogo.png" alt=""/>  Chess Shop
                </Link>

                {/*<Navbar.Brand href="#home"><img src="kingLogo.png"/> Chess Shop </Navbar.Brand>*/}
                <Nav className="mr-auto">
                    <Link to={""} className="nav-link">Home</Link>
                    <Link to={"products"} className="nav-link">Products</Link>
                    <Link to={"add-product"} className="nav-link">Add New Product</Link>
                    <Link to={"manufacturers"} className="nav-link">Manufacturers</Link>
                    <Link to={"add-manufacturer"} className="nav-link">Add New Manufacturer</Link>
                </Nav>
                <Form inline>
                    <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                    <Button variant="outline-light">Search</Button>
                </Form>
            </Navbar>
        );
    }
}

