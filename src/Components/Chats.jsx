import React, { Component } from 'react'
import ChatRoom from './ChatRoom';


class Chats extends Component {
    constructor(props) {
        super(props);
        this.state = {
            chatId: "CS201", //need to start as null and set to first enrolled class
        }

    }
    //api call to class list
    updateChatId = (props) => {
        this.setState({
            chatId: props
        })
    }
    render() {

        const items = [{ "id": "1", "name": "CS170" }, { "id": "2", "name": "CS201" }]
        return (

            <div>
                <div className="row">
                    <div className="col-4">
                        <div className="list-group">
                            {items.map(item => (
                                <button type="button" className="list-group-item list-group-item-action"
                                    onClick={() => this.updateChatId(item.name)}
                                    key={item.id}>
                                    {item.name}
                                </button>
                            ))}
                        </div>
                    </div>
                    <div className="col-8">
                        <div className="row">
                            <h1>{this.state.chatId}</h1>
                        </div>
                        <ChatRoom classId={this.state.chatId} />
                    </div>
                </div>


            </div >

        );
    }


}


export default Chats