import React, { Component , useState } from 'react';
import axios from 'axios';
// const API = 'https://hn.algolia.com/api/v1/search?query=';
// const DEFAULT_QUERY = 'redux';
 
class Other extends Component {
    
    state = {
        memes:[],
        displayValue:'none',
        editmeme:{
          id: '',
          name : '',
          caption:'',
          url : ''
        }
    }
    
    
 
  componentDidMount() {
    setTimeout(() => {
      console.log("delay"); }, 1000);
    this.setState({ isLoading: true });
 
    const url='https://frozen-cliffs-77329.herokuapp.com/memes';
    
    axios.get(url)
    .then(response => response.data)
    .then((data) => {
      this.setState({ memes: data })
      console.log(this.state.memes)
     })
    }

    myEditSubmitHandler = (event) => {
      event.preventDefault();
      let id = event.target.editId.value;
      let name=event.target.editName.value;
      let caption=event.target.editMeme.value;
      let url=event.target.editUrl.value;
      //alert(name);
      const meme = { id:id,name:name,caption:caption,url:url  };
      console.log(meme)
      // axios.patch('https://frozen-cliffs-77329.herokuapp.com/memes/'+id, meme)
      //     .then(res=>{
      //       console.log(res.data);
      //     }
      // );
      // setTimeout(function(){console.log("Delay") }, 2000);
      axios.patch('https://frozen-cliffs-77329.herokuapp.com/memes/'+id, meme)
          .then(res=>{
            console.log(res.data);
          }
      );
      window.location.reload();
      
      
    }

    testClick(meme){
      alert(meme.name);
      console.log(meme.id);
      this.state.editmeme = 
        {
         id : meme.id,
         name:meme.name,
         caption:"My Caption",
         url : "My Url"
       }
      
      alert("Next");
      alert(this.state.editmeme.caption);

    }
    handleClick() {
      this.setState(({ displayValue }) => ({
        displayValue:'block'
      }));
    }
    handleCloseClick() {
      this.setState(({ displayValue }) => ({
        displayValue:'none'
      }));
    }
  render (){
    // let closeModal = () => this.setState({ open: false })
 
    // let saveAndClose = () => {
    //   api.saveData()
    //     .then(() => this.setState({ open: false }))
    // }
    const spacing = 30;
    return (
        <div className="Other">

            <h1>Memes</h1>
            <br/>
            <div className="col-xs-12 memebox" style={{paddingLeft:spacing+'px'}} >
                {this.state.memes.map((meme) => (
                        
                        <div className="meme-body">
                            <p className="meme-name">{meme.name}</p> 
                            <p className="meme-caption" >{meme.caption}</p>
                            <p className="meme-url" >
                              <img src={meme.url} width="150" height="150" />
                              <div style={{width:"28%",paddingTop:"10px"}}>
                              <button type="button" className="btn btn-success btn-block" data-toggle="modal" data-target={"#myModal"+meme.id} >
                                    Edit
                                </button>
                              </div>
                               

                            </p>
                            <div className="container">
                                  {/* <!-- Button to Open the Modal --> */}
                                  

                                  {/* <!-- The Modal --> */}
                                  <div className="modal fade" id={"myModal"+meme.id}>
                                    <div className="modal-dialog modal-dialog-centered">
                                    <form onSubmit={this.myEditSubmitHandler} style={{padding:"0px",width:"100%"}}>
                                      <div className="modal-content">
                                      
                                        {/* <!-- Modal Header --> */}
                                        <div className="modal-header">
                                          <h4 className="modal-title">Meme No : {meme.id}</h4>
                                          <button type="button" className="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        
                                        {/* <!-- Modal body --> */}
                                        <div className="modal-body">
                                          <ul style={{listStyleType:"none"}}>
                                            <li>Meme Owner : {meme.name}</li>
                                            <li><input type="text" defaultValue={meme.caption} name="editMeme"/></li>
                                            <li><input type="text" defaultValue={meme.url} name="editUrl"/></li>
                                            <input type="hidden" value={meme.id} name="editId"/>
                                            <input type="hidden" value={meme.name} name="editName"/>
                                          </ul>
                                        </div>
                                        
                                        {/* <!-- Modal footer --> */}
                                        <div className="modal-footer">
                                        <input type='submit' />
                                        </div>
                                        
                                      </div>
                                      </form>
                                    </div>
                                  </div>
                                  
                                </div>
                            
                        </div>
                    
                ))}
                
              </div>
              {/* <div>
                  <button type='button'>Launch modal</button>
          
                  <Modal
                    show={this.state.open}
                    onHide={closeModal}
                    aria-labelledby="ModalHeader"
                  >
                    <Modal.Header closeButton>
                      <Modal.Title id='ModalHeader'>A Title Goes here</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                      <p>Some Content here</p>
                    </Modal.Body>
                    <Modal.Footer>
                      // If you don't have anything fancy to do you can use
                      // the convenient `Dismiss` component, it will
                      // trigger `onHide` when clicked
                      <Modal.Dismiss className='btn btn-default'>Cancel</Modal.Dismiss>
          
                      // Or you can create your own dismiss buttons
                      <button className='btn btn-primary' onClick={saveAndClose}>
                        Save
                      </button>
                    </Modal.Footer>
                  </Modal>
                </div> */}
                                

        </div>
    );
  }
}
 
export default Other;