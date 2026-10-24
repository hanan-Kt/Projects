import numpy as np
from scipy.sparse.csgraph import floyd_warshall, dijkstra

graph = np.array([
    [0, 2, 6, 0, 0, 0, 0],
    [2, 0, 0, 5, 0, 0, 0],
    [6, 0, 0, 8, 0, 0, 0],
    [0, 5, 8, 0, 10, 15, 0],
    [0, 0, 0, 10, 0, 0, 2],
    [0, 0, 0, 15, 0, 0, 6],
    [0, 0, 0, 0, 2, 6, 0]
])

fw_result = floyd_warshall(csgraph=graph, directed=False)
dijkstra_result = dijkstra(csgraph=graph, directed=False, indices=0)

print(fw_result)
print(dijkstra_result)