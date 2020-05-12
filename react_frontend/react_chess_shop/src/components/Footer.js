import React, {Component} from "react";
import {Col, Container, Navbar, Row} from "react-bootstrap";

export default class Footer extends Component {
    render() {
        let fullYear = new Date().getFullYear();

        return (
            <Navbar fixed="bottom" bg="dark" variant="dark" align="center">
                <Container lg={12} align="center">
                    <Row align="center">
                        <Col  className="text-muted text-center" align="center">
                            <div align="center"> All Rights Reserved by FINKI {fullYear-1}-{fullYear}</div>
                        </Col>
                    </Row>
                </Container>
            </Navbar>
        );
    }
}