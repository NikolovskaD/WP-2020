import React, {Component} from "react";
import {Jumbotron} from "react-bootstrap";
import {faChessKnight, faChessQueen} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";


export default class Welcome extends Component{
    render() {
        return (
            <div>
                <div>
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
                </div>
                <div className="text-white text-center"><br/><br/>
                    <p><FontAwesomeIcon icon={faChessKnight} />  Wake up your mind, try solving a puzzle or two!</p>
                    <iframe src="https://livetactics.chessbase.com" width="400" height="440"/>
                </div>
                <br/><br/><br/><br/>
            </div>



        );
    }
}


/*“Chess is beautiful enough to waste your life for.” – Hans Ree*/
