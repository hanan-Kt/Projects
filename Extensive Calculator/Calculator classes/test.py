import numpy as np
import time
import os
import psutil

def get_memory_usage():
    """Prints current RAM usage in Google Colab environment."""
    process = psutil.Process(os.getpid())
    mem_mb = process.memory_info().rss / (1024 ** 2)
    total_ram = psutil.virtual_memory().total / (1024 ** 3)
    return f"RAM Used: {mem_mb:.2f} MB / Total RAM: {total_ram:.2f} GB"

print("=" * 60)
print("GOOGLE COLAB NUMPY STRESS TEST")
print(get_memory_usage())
print("=" * 60)

# ---------------------------------------------------------
# STAGE 1: CPU Multi-Threading Matrix Multiplication Test
# ---------------------------------------------------------
print("\n[STAGE 1] Testing CPU & OpenBLAS performance...")
size = 8000  # 8000x8000 matrix ≈ ~512 MB per array in float64
print(f"Generating two ({size}x{size}) float64 matrices (~1 GB total)...")

t0 = time.time()
A = np.random.randn(size, size)
B = np.random.randn(size, size)
print(f"Matrix creation time: {time.time() - t0:.2f} seconds")
print(get_memory_usage())

print("Executing heavy matrix multiplication (A @ B)...")
t0 = time.time()
C = np.matmul(A, B)
t_matmul = time.time() - t0
gflops = (2 * (size ** 3)) / (t_matmul * 1e9)

print(f"Matrix multiplication complete in {t_matmul:.2f} seconds.")
print(f"Estimated Compute Performance: {gflops:.2f} GFLOPS")
print(get_memory_usage())

# Cleanup Stage 1 matrices to avoid early crash
del A, B, C

# ---------------------------------------------------------
# STAGE 2: CPU-Intensive Linear Algebra (SVD)
# ---------------------------------------------------------
print("\n[STAGE 2] Testing CPU compute bound via SVD decomposition...")
svd_size = 5000
print(f"Running Singular Value Decomposition (SVD) on a ({svd_size}x{svd_size}) matrix...")

X = np.random.randn(svd_size, svd_size)
t0 = time.time()
U, S, Vt = np.linalg.svd(X)
print(f"SVD computed in {time.time() - t0:.2f} seconds.")

del X, U, S, Vt

# ---------------------------------------------------------
# STAGE 3: RAM Stress Test (Pushing close to Colab Limit)
# ---------------------------------------------------------
print("\n[STAGE 3] Pushing System Memory (RAM) limit...")

# Free tier Colab has ~12.7 GB total RAM. We allocate incrementally in 1 GB blocks.
allocated_blocks = []
block_size = (11500, 11500) # Each block is ~1.05 GB of float64 data

try:
    for i in range(1, 20):
        print(f"Allocating Block #{i} (~1.05 GB)...", end=" ")
        arr = np.ones(block_size, dtype=np.float64)
        allocated_blocks.append(arr)
        print(get_memory_usage())
except MemoryError:
    print("\n[WARNING] Out of Memory (MemoryError) caught gracefully by Python!")
    print("You have hit the absolute maximum RAM limit allowed in your current runtime environment.")

print("\n" + "=" * 60)
print("TEST COMPLETE: Colab survived the workload without runtime termination!")
print("=" * 60)