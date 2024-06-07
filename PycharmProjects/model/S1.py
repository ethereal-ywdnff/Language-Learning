import numpy as np
import matplotlib.pyplot as plt
from scipy.spatial.distance import cdist


'''
cdist calculates the pair wise distance between agents (d_ij)
'''
n_agents = 12                   #Number of simulated pups
temperature_ambient = 10      #Ambient temperature, T_a
thermogenesis = 6.32            #G
temperature_pref = 37.        #Preferred temperature, T_p
temperature_init = 30.        #Initial temperature
radius_agent = 1.0              #Radius of pup, r
radius_arena = 10.0             #Radius of arena, r_arena
conductance_contact = 2.5       #heat conductance between pup-pup, k_2
conductance_exposed = 1.0       #heat conductance between pup-exposed, k_1
move_speed = 0.3                #v_2
angular_speed = 200.0           #v_1

sigma = 100.                    #parameter used in sigmoid function
n_thermometers = 1000           #number of thermometers that tile the pups surface

n_trials = 5                 #number of repeat experiments
dt = 0.05
time_steps = 10000
def normalise(x):
	'''
	Takes a NxM matrix and normalises across axis-1
	'''
	return x / np.sqrt(np.sum(x**2, axis=1))[:, np.newaxis]


data = np.zeros((n_trials, time_steps, n_agents, 6))
print('Number of Agents: ' + str(n_agents))
print('Ambient Temperature: ' + str(temperature_ambient) + 'C')
print('Thermogenesis: ' + str(thermogenesis))
print('Beginning experiment 1 of ' + str(n_trials) + ':')
print('(Don`t worry about the division by zero error...!)')

for i in range(n_trials):
    positions = np.random.randn(n_agents,2)
    orientations = normalise(np.random.randn(n_agents,2))
    body_temperatures = np.ones(n_agents) * temperature_init
    for t in range(time_steps):
        ### Collision detection ###  Eq. 9 (part 3)
        dist_agents = cdist(positions, positions, 'euclidean')
        overlap = np.clip(radius_agent - 0.5 * dist_agents,0,radius_agent)
        np.fill_diagonal(overlap, 0.)

        collision_vectors = np.zeros((n_agents, 2))
        for j in range(n_agents):
            vecs = positions[j] - positions
            vecs *= np.nan_to_num((overlap[j]/np.sqrt(np.sum(vecs**2, axis=1)))[:,np.newaxis])
            collision_vectors[j] = np.sum(vecs,axis=0)
        positions += dt * collision_vectors

        ### Boundary ### Eq. 9 (part 2)
        positions -= dt * np.clip(np.sqrt(np.sum(positions**2, axis=1)) - (radius_arena - radius_agent), 0, np.inf)[:, np.newaxis] * positions / np.sqrt(np.sum(positions**2, axis=1))[:,np.newaxis]

        ### thermometers ### x_ik, y_ik
        theta = np.arctan2(orientations[:,0], orientations[:,1])
        template = np.linspace(0,2*np.pi, n_thermometers, endpoint = False)+np.pi / n_agents
        N, M = np.meshgrid(theta, template)
        S, C = np.sin(N+M), np.cos(N+M)
        thermometers = radius_agent * np.rollaxis(np.array([S,C]), 0, 3) + positions[np.newaxis]

        ### Temperature Sensing ### 
        distance_thermometers = cdist(thermometers.reshape(-1,2), positions, 'euclidean')
        closest_agent = np.argmin(distance_thermometers, axis=1)
        overlap_thermometers = distance_thermometers[range(n_thermometers*n_agents), closest_agent] < radius_agent - 1e-10
        I = np.ones((n_thermometers*n_agents))*temperature_ambient
        I[overlap_thermometers] = body_temperatures[closest_agent][overlap_thermometers]
        sensor = I.reshape(n_thermometers, n_agents)
        average_sensor = np.average(I.reshape(2,int(n_thermometers) // 2,int(n_agents)), axis=1)
        ###F(T_L), F(T_R)###
        s1,s2 = 1. / (1.+np.exp((-1. / sigma)*(temperature_pref - body_temperatures[np.newaxis])*average_sensor))

        m1,m2 = (s2/(s1+s2)), (s1/(s1+s2))

        ### Orient ### Eq. 8
        phi = dt * np.arctan(angular_speed * (m1 - m2))
        s,c = np.sin(phi), np.cos(phi)
        rotation = np.array([[c,-s],[s,c]])

        d_orientations = np.sum(rotation * np.rollaxis(orientations, 0, 2)[np.newaxis], axis=1)
        orientations = normalise(np.rollaxis(d_orientations, 0, 2))

        ### Move ### Eq. 9 (part 1)
        positions += dt * move_speed * orientations

        ### Thermodynamics ### Eq 1 (and 6)
        temperature_gradients = sensor - body_temperatures[np.newaxis]
        temperature_gradients[overlap_thermometers.reshape(n_thermometers,-1)] *= conductance_contact
        temperature_gradients[(1-overlap_thermometers.reshape(n_thermometers,-1)).astype(bool)] *= conductance_exposed

        d_temperatures = np.average(temperature_gradients,axis=0) + thermogenesis
        body_temperatures += dt * d_temperatures

        metric = np.average(overlap_thermometers.reshape(n_thermometers, n_agents), axis=0)
        data[i,t] = np.hstack((positions, orientations,body_temperatures[:,np.newaxis], metric[:,np.newaxis]))
    print('...experiment ' + str(i+1) + ' complete,')
Tb, H = np.average(data[:,1000:,:,-2]), np.average(data[:,1000:,:,-1])
print('Average body temperature (T_b): ' + str(Tb))
print('Huddling (1 - eta): ' + str(H))
