import http from 'k6/http';

export let options = {
    scenarios: {
     hello: {
        exec: 'hello_endpoint',
        executor: 'constant-arrival-rate',
        duration: '30s',
        preAllocatedVUs: 500,
        rate: 500, // requests per second
     },
     many: {
        exec: 'many',
        executor: 'constant-arrival-rate',
        duration: '30s',
        preAllocatedVUs: 500,
        rate: 500, // requests per second
     }
    }
};

export function hello_endpoint() {
  http.get('http://host.docker.internal:8081/loom');
};

export function many() {
  http.get('http://host.docker.internal:8081/loom/many');
};