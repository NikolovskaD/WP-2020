import React, {Component} from "react";
import {Jumbotron} from "react-bootstrap";


export default class Welcome extends Component{
    render() {
        return (
            <Jumbotron className="bg-dark text-white text-center">
                <h1>Welcome to the Chess Shop!</h1>
                <blockquote className="blockquote mb-0">
                    <p>
                        Chess, like love, like music, has the power to make men happy.
                    </p>
                    <footer className="blockquote-footer">
                        Siegbert Tarrasch
                    </footer>
                </blockquote>
            </Jumbotron>
        );
    }
}


/*“Chess is beautiful enough to waste your life for.” – Hans Ree*/
