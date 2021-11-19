'use scrict'

const postlist = document.querySelector('.post-list');
let output = ''
const addPostForm = document.querySelector('.add-post-form');
const nameValue = document.getElementById('name-value');
const ageValue = document.getElementById('age-value');
const tuitionValue = document.getElementById('tuition-value');
const magicTypeValue = document.getElementById('magicType-value');
const url = "http://localhost:9000/Student"
const btnsubmit = document.getElementById('button');

const renderPosts = (posts) => {posts.forEach(post => {
            output += `<div class="card mt-4 col-md-6 bg-ligt" >
  <div class="card-body" data-id=${post.id}>
    <h5 class="card-title">${post.name}</h5>
    <h6 class="card-subtitle mb-2 text-muted">${post.tuition}</h6>
     <h6 class="card-subtitle mb-2 text-muted">${post.age}</h6>
    <p class="card-text">${post.magicType}</p>
    <a href="#" class="card-link" id="edit-post">Edit</a>
    <a href="#" class="card-link" id="delete-post">Delete</a>
  </div>
</div>`
                ;
        
        });
        postlist.innerHTML = output;
    
}

// Get Method Func

fetch('http://localhost:9000/Student/getAll')
    
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
        fetch(`${"http://localhost:9000/Student/delete"}/${id}`,
            {
                method: 'DELETE',
                 
            })
            .then(response => response.json())
        .then(() => location.reload())
         
    }


    //edit button
    if (editButtPressed) {
        const parent = e.target.parentElement;
        let nameContent = parent.querySelector('.card-title').textContent;
        let magicTypeContent = parent.querySelector('.card-text').textContent;

        nameValue.value = nameContent;
        magicTypeValue.value = magicTypeContent;
    }

//updating the Students Details
    btnsubmit.addEventListener("click", (e) => {
        console.log('updated')
        e.preventDefault()
        fetch(`${'http://localhost:9000//Student/update'}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: nameValue,
                age: ageValue,
                tuition: tuitionValue,
                magicType: magicTypeValue
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
            age: ageValue.value,
            tuition: tuitionValue.value,
            magicType: magicTypeValue.value
        })
    })

        .then(res => res.json())
        .then(data => {
            const dataArray = [];
            dataArray.push(data);
            renderPosts(dataArray)
    })


        
    
    
})
