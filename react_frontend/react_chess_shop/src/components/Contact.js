import React, {Component} from "react";
import {Jumbotron} from "react-bootstrap";


export default class Contact extends Component{
    render() {
        return (
            <div>
                <div>
                    <Jumbotron className="bg-dark text-white text-center">
                        <h1>Let's get in touch!</h1>
                        <blockquote className="blockquote mb-0">
                            <p> Like us on Facebook, follow us on Instragram </p>
                        </blockquote><br/><br/>

                        <h2>Have a question? </h2>
                        <blockquote className="blockquote mb-0">
                            <p> Contact us via Social Media or WhatsApp </p>
                        </blockquote>
                    </Jumbotron>
                </div>
            </div>
        );
    }
}



