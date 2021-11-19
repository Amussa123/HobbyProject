'use strict';

let header = document.querySelector('h2');
console.log(header);

fetch('http://localhost:9000//Student/getAll')
    .then((response) => {                              
        if (response.status !== 200) {               
            console.error(`status: ${response.status} `);
            return;
        }
        response.json()                                
            .then((data) => {
                console.log(data);
         
            for(let obj of data){
                console.log(obj);
                createCard(obj);
            }
            
        }).catch((error) => {
            console.error(`${error}`);                 
        });
    });



let parentDiv = document.querySelector('#parentDiv');

let createCard = (data) => {
    // Creating elements
    let newCard = document.createElement('div');
    let newCardBody = document.createElement('div');
    let newid = document.createElement('h4');
    let newName = document.createElement('h4');
    let newtuition = document.createElement('h4');
    let newage = document.createElement('h4')
    let newmagicType = document.createElement('h4');

   
    newCard.classList = "card";
    newCardBody.classList = "card-body";
    newid.classList = "card-id";
    newName.classList = "card-Name";
    newage.classList = "card-age"
    newtuition.classList = "card-tuition";
    newmagicType.classList = "card-magicType";
 

    
    newid.textContent = data.id;
    newName.textContent = data.name;
    newtuition.textContent = data.tuition;
    newage.textContent = data.age
    newmagicType.textContent = data.magicType;

    

    newCardBody.appendChild(newid);
    newCardBody.appendChild(newName);
    newCardBody.appendChild(newtuition);
    newCardBody.appendChild(newage)
    newCardBody.appendChild(newmagicType);

    newCard.appendChild(newCardBody);

    parentDiv.appendChild(newCard);


}