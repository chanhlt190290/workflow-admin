import React, { Component } from 'react';

import 'bootstrap/dist/css/bootstrap.min.css';

class Index extends Component {
    
    componentDidMount(){
        // fetch('/api/v1/requests/21').then(response=>{
        //   console.log(response);
        //   response.json();
        // }).then((request) => { 
        //   console.log(request);
        // });

        // fetch('/api/v1/processes', {
        //   method: 'POST',
        //   headers: {
        //     'Accept': 'application/json',
        //     'Content-Type': 'application/json',
        //   },
        //   body: JSON.stringify({
        //     "updatedBy":1,
        //     "createdBy":1,
        //     "name": "process 01"
        //   })
        // }).then(response=>{
        //     console.log(response);
        //     response.json();
        //   }).then((request) => { 
        //     console.log(request);
        //   });
    }
    
  render() {
    return (
      <div>
        <div><h1 className="text-center">Hello</h1></div>
        
      </div>
    );
  }
}

export default Index;
