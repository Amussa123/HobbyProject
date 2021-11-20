'use strict'

const postlist = document.querySelector('.post-list');
let output = ''
const addPostForm = document.querySelector('.add-post-form');
const schoolNameValue = document.getElementById('name-value');
const magicClassValue = document.getElementById('magicClass-value');
const url = "http://localhost:9000/Student"
const btnsubmit = document.getElementById('button');

const renderPosts = (posts) => {posts.forEach(post => {
            output += `<div class="card mt-4 col-md-6 bg-ligt" >
  <div class="card-body" data-id=${post.id}>
    <h5 class="card-title">${post.schoolName}</h5>
    <p class="card-text">${post.magicClass}</p>
    <a href="#" class="card-link" id="edit-post">Edit</a>
    <a href="#" class="card-link" id="delete-post">Delete</a>
  </div>
</div>`
                ;
        
        });
        postlist.innerHTML = output;
    
}

// Get Method Func

fetch('http://localhost:9000/School/getAll')
    
    .then(response => response.json())
    .then(data => renderPosts(data))


//delete and Edit
postlist.addEventListener('click', (e) => {
    e.preventDefault();
    let deleteButtPressed = e.target.id == 'delete-post';
    let editButtPressed = e.target.id == 'edit-post';

    let id = (e.target.parentElement.dataset.id);


    //delete Func

    if (deleteButtPressed) {
        fetch(`${"http://localhost:9000/School/delete"}/${id}`,
            {
                method: 'DELETE',
                 
            })
            .then(response => response.json())
        .then(() => location.reload())
         
    }


    //edit button
    if (editButtPressed) {
        const parent = e.target.parentElement;
        let schoolNameContent = parent.querySelector('.card-title').textContent;
        let magicClassContent = parent.querySelector('.card-text').textContent;

        nameValue.value = schoolNameContent;
        magicTypeValue.value = magicClassContent;
    }

//updating the Students Details
    btnsubmit.addEventListener("click", (e) => {
        console.log('updated')
        e.preventDefault()
        fetch(`${'http://localhost:9000//School/update'}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                schoolName: schoolNameValue,
                magicClass: magicClassValue
            })
        })
            .then(response => response.json())
        .then (() => location.reload)
       
})
  
    
});



//Create Func
addPostForm.addEventListener('submit', (e) => {
    e.preventDefault

    console.log(nameValue.value)

    fetch('http://localhost:9000/Student/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: nameValue.value,
            magicClass: magicClassValue.value
        })
    })

        .then(res => res.json())
        .then(data => {
            const dataArray = [];
            dataArray.push(data);
            renderPosts(dataArray)
    })


        
    
    
})
