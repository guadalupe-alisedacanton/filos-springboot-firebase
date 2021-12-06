import React, { Component } from 'react'


class List extends Component {


    render() {

        const items = this.props.items
        return (

            <div>
                <h3 className="display-3"> {this.props.name}  </h3>
                <ul className="list-group">
                    {items.map(item => (
                        <li className="list-group-item" key={item.id}>{item}</li>
                    ))}
                </ul>

            </div>

        );
    }
}

export default List