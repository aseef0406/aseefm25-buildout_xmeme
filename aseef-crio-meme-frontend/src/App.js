import React,{Component} from "react";
import axios from 'axios';
import './App.css';



class App extends Component{

  constructor(props) {
    super(props);
    this.state = {
      id: null,
      name:'',
      caption: '',
      url:''
    };
  }
  mySubmitHandler = (event) => {
    
    event.preventDefault();
    let name=event.target.name.value;
    let caption=event.target.caption.value;
    let url=event.target.url.value;
    //alert(name);
    const meme = { name:name,caption:caption,url:url  };
    // axios.post('https://frozen-cliffs-77329.herokuapp.com/memes', meme)
    //     .then(res=>{
    //       console.log(res.data);
    //     }
    // );
    // setTimeout(function(){console.log("Delay") }, 500);
    console.log(meme)
    axios.post('https://frozen-cliffs-77329.herokuapp.com/memes', meme)
        .then(res=>{
          console.log(res.data);
        }
    );
    window.location.reload();
    
    
  }
 
	
  getMemes() {
    axios.get('http://localhost:8080/memes')
        .then(res => {
          //const emps = res.data;
          //this.setState({ emps });
          console.log(res.data);
          
        })
        console.log("Ok");
  }
  getMemesbyId() {
    axios.get('http://localhost:8080/memes/1')
        .then(res => {
          //const emps = res.data;
          //this.setState({ emps });
          console.log(res.data);
          
        })
        console.log("Ok");
  }
  postMemes() {
    const meme = { name:'Aseef',caption:'Caption1',url:'url1'  };
    axios.post('http://localhost:8081/memes', meme)
        .then(res=>{
          console.log(res);
        }
        );
  }
  componentDidMount(){
    //this.getMemes();
    //this.postMemes();

  }

  render (){
    return (
    // <div className="App">
    //   <h1>Hi, It's Aseef</h1>
    //   <button className="mybutton" onClick={this.getMemes}>
    //     Ok
    //   </button>
    //   <button className="mybutton" onClick={this.postMemes}>
    //     Post
    //   </button>
    //   <button className="mybutton" onClick={this.getMemesbyId}>
    //     Get ID
    //   </button>
    // </div>
      <form onSubmit={this.mySubmitHandler} >
        <h1>Meme Stream </h1>
        <label >Meme Owner</label>
        <input type="text" name="name" placeholder="Enter Your Full Name" required/>

        <label >Caption</label>
        <input type="text"  name="caption" placeholder="Be creative with caption" required/>
        <label >Meme URL</label>
        <input type="text"  name="url" placeholder="Enter Meme URL" required/>
        {/* <p>Enter your name:</p>
        <input
          type='text'
          name='name'
          // onChange={this.myChangeHandler} 
          required
        />
        <p>Enter your Caption:</p>
        <input
          type='text'
          name='caption'
          // onChange={this.myChangeHandler}
          required
        />
        <p>Enter your Url:</p>
        <input
          type='text'
          name='url'
          // onChange={this.myChangeHandler}
          required
        /> */}
        <br/>
        <br/>
        <input type='submit' />
      </form>
    );
  }




}

export default App;
