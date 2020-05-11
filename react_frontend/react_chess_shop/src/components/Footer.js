import React, {Component} from "react";
import {Col, Container, Navbar, Row} from "react-bootstrap";

export default class Footer extends Component {
    render() {
        let fullYear = new Date().getFullYear();

        return (
            <Navbar fixed="bottom" bg="dark" variant="dark">
                <Container>
                    <Row>
                        <Col lg={12} className="text-muted text-center" >
                            <div>{fullYear}, All Rights Reserved by FINKI</div>
                        </Col>
                    </Row>
                </Container>
            </Navbar>
        );
    }
}